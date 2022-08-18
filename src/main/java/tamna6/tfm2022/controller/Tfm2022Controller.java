package tamna6.tfm2022.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tamna6.tfm2022.dto.TfmUserForm;
import tamna6.tfm2022.entity.TfmUser;
import tamna6.tfm2022.repository.Tfm2022Repository;

@Controller
@Slf4j
@Api(value="Swagger Test V1")
public class Tfm2022Controller {

    @Autowired
    private Tfm2022Repository tfm2022Repository;

    @ApiOperation(value="로그인", notes="로그인notes")
    @GetMapping("")
    public String tfmLogin(){
        return "/login";
    }

    @GetMapping("signup")
    public String tfmSignUp(){
        return "/signup";
    }

    @PostMapping("/tfm2022/create")
    public String createTfmAccount(TfmUserForm form){

        //1. DTO -> Entity 변환
        TfmUser tfmuser = form.toEntity();
        log.info(form.toString());

        //2. Repository에게 Entity를 DB안에 저장
        TfmUser saved = tfm2022Repository.save(tfmuser);
        log.info(saved.toString());

        return "redirect:/";
    }

    @GetMapping("main")
    public String tfmMain(){
        return "/main";
    }

    @GetMapping("detail")
    public String tfmDetail(){
        return "detail";
    }

    @GetMapping("my")
    public String tfmMy(){
        return "my";
    }

    @GetMapping("play")
    public String tfmPlay(){
        return "play";
    }
}
