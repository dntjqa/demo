package com.thc.sprapi.controller;

import com.thc.sprapi.dto.TbboardDto;
import com.thc.sprapi.service.TbboardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Tag(name = "1. 제목입니다.",
        description = "설명입니다.")
@RequestMapping("/api")
@RestController //페이지를 보여주는 것이 아니라, Rest 방식을 사용할때!!
public class DefaultRestController {

    @Operation(summary = "요약제목",
            description = "~~을 위한 컨트롤러 (~~만 접근 가능) <br />"
                    + "@param Tb~~Dto tb~~Dto <br />"
                    + "@return HttpStatus.CREATED(201) ResponseEntity\\<Tb~~Dto\\> <br />"
                    + "@exception 중복 <br />"
    )
    @PostMapping("btest")
    public int btest(
            @RequestBody TbboardDto.TbboardCreateDto params
    ){
        System.out.println("1! params : " + params);
        int result_int = tbboardService.create1(params);
        return result_int;
    }

    /*
    public ResponseEntity<TbboardDto.TbboardCreateDto> saveTbcmt(@Valid @RequestBody TbboardDto.TbboardCreateDto params) {
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
     */

    @PostMapping("itest")
    public int itest(
            @RequestBody Map<String, Object> map
    ){
        int try_num = Integer.parseInt(map.get("try_num") + "");
        System.out.println("try_num : " + try_num);
        //원하는 정보를 가공해서, 제공함..
        /*
        !해야 하는 내용들..
         */
        int result_int = 0;
        long millis = System.currentTimeMillis();
        result_int = (int) millis % 10;

        if(try_num == 17){
            result_int = 0;
        } else if(try_num < 17){
            if(result_int == 0){
                result_int = 9;
            }
        }

        return result_int;
    }

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final TbboardService tbboardService;
    public DefaultRestController(TbboardService tbboardService) {
        this.tbboardService = tbboardService;
    }
    //오토와이어드 쓸수도 있지만, 이렇게 주입하는 방식을 선호!!

    @PostMapping({"/mtest"})
    public Map<String, Object> getMtest(
            //@RequestParam String aaa
            //
            @RequestBody Map<String, Object> map
    ) {
        Map<String, Object> map_tbboard = tbboardService.select(map);

        logger.info("!!!!!!!!!!!!!map_tbboard//" + map_tbboard);
        return map_tbboard;
    }

    @GetMapping({"/test"})
    public Map<String, Object> getTest(
            //@RequestParam String aaa
            //
            @RequestBody Map<String, Object> map
    ) {
        //System.out.println("!!!!!!!!!!!!!aaa//" + aaa);
        //System.out.println("!!!!!!!!!!!!!map//" + map);
        Map<String, Object> a_map = new HashMap<>();
        a_map.put("name", "sprapi!!");
        a_map.put("phone", "010!!");
        return a_map;
    }

    @PostMapping({"/ptest"})
    public Map<String, Object> getPtest(
            @RequestBody Map<String, Object> map
    ) {
        System.out.println("!!map : " + map);
        int result_int = tbboardService.create(map);
        Map<String, Object> a_map = new HashMap<>();
        a_map.put("result_int", result_int);
        return a_map;
    }

    @GetMapping({"/create"})
    public int createTbboard(
            @RequestParam(value = "aaa", required = true) String aaa
            /*
            @RequestParam(value = "title", required = true) String title
            ,@RequestParam(value = "content", required = true) String content
    */
    ) {
        System.out.println("aaa//" + aaa);
        String title = "122334";
        String content = "2244555";
        System.out.println(title + "//" + content);
        //등록하기
        Map<String, Object> a_map = new HashMap<>();
        a_map.put("title", title);
        a_map.put("content", content);

        int result_int = tbboardService.create(a_map);
        /*
        Tbboard tbboard = Tbboard.of("제목 예시", "내용 예시");
        tbboard = tbboardRepository.save(tbboard);
        */
        return result_int;
    }

    @GetMapping({"/update"})
    public int updateTbboard(
    ) {
        Map<String, Object> a_map = new HashMap<>();
        a_map.put("id", "a29d2abd-7df2-4e3c-acbd-61c84545c52a");
        a_map.put("title", "updated");
        int result_int = tbboardService.update(a_map);
        return result_int;
    }

    /*
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTbboardcate(@PathVariable("id") String id) {
        tbboardcateService.deleteTbboardcate(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @Operation(summary = "게시물선택카테고리 정보 목록 조회(페이지)",
            description = "게시물선택카테고리정보 목록 조회를 위한 컨트롤러 (게시물선택카테고리만 접근 가능) <br />"
                    + "@param TbboardcatePagedListDto tbboardcatePagedListDto <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<PagedListDto\\> <br />"
                    + "@exception 없음 <br />"
    )
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/pagedList")
    public ResponseEntity<PagedListDto> getPagedTbboardcateList(@Valid @RequestBody TbboardcatePagedListDto tbboardcatePagedListDto) {
        return ResponseEntity.status(HttpStatus.OK).body(tbboardcateService.getPagedTbboardcateMybatisList(tbboardcatePagedListDto));
    }
    */

}
