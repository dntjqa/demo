package com.thc.sprapi.service;

import com.thc.sprapi.domain.Tbboard;
import com.thc.sprapi.dto.TbboardDto;
import com.thc.sprapi.mapper.TbboardMapper;
import com.thc.sprapi.repository.TbboardRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@Service
public class TbboardService {

    /*
    @Autowired
    TbboardRepository tbboardRepository;
    */
    @Autowired
    TbboardMapper tbboardMapper;

    private final TbboardRepository tbboardRepository;
    public TbboardService(TbboardRepository tbboardRepository) {
        this.tbboardRepository = tbboardRepository;
    }

    public int create(Map<String, Object> param){
        int result_int = 0;
        Tbboard tbboard = Tbboard.of(param.get("title") + "", param.get("content") + "");
        //Tbboard tbboard2 = Tbboard.of(param.get("title") + "");
        tbboard = tbboardRepository.save(tbboard);

        if((tbboard.getId() + "").equals("null")){
        } else {
            result_int = 200;
        }
        return result_int;
    }
    public int create1(TbboardDto.TbboardCreateDto params){
        int result_int = 0;
        Tbboard tbboard = Tbboard.of(params.getTitle(), params.getContent());
        tbboard = tbboardRepository.save(tbboard);

        if((tbboard.getId() + "").equals("null")){
        } else {
            result_int = 200;
        }
        return result_int;
    }

    public int update(Map<String, Object> param){
        //c23693ff-ac58-4a31-9f36-a15e6aa1553b
        String id = param.get("id") + "";
        String title = param.get("title") + "";
        Tbboard tbboard1 = tbboardRepository.findById(id).orElseThrow(new Supplier<EntityNotFoundException>() {
            @Override
            public EntityNotFoundException get() {
                return new EntityNotFoundException("id : ");
            }
        });

        System.out.println("1.title : " + tbboard1.getTitle());
        tbboard1.setTitle(title);
        tbboardRepository.save(tbboard1);
        System.out.println("2.title : " + tbboard1.getTitle());

        int result_int = 0;
        if((tbboard1.getId() + "").equals("null")){
        } else {
            result_int = 200;
        }
        return result_int;
    }
    public Map<String, Object> select(Map<String, Object> param){
        //c23693ff-ac58-4a31-9f36-a15e6aa1553b

        Map<String, Object> map_tbboard = new HashMap<>();
        map_tbboard = tbboardMapper.get(param);

        return map_tbboard;
    }
}
