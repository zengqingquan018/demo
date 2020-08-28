package com.example.demo2.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.plaf.PanelUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.pattern.PathPattern.PathRemainingMatchInfo;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/7/15 13:52
 */
@RestController
public class FileController {

    @Autowired
    private IdworkConfig idworkConfig;

    @GetMapping("/testString")
    public Map testString() {
        Map map = new HashMap();
        String a = "1111";
        Long b = 1111L;
        map.put("a",a);
        map.put("b",b);
        return map;
    }

    @GetMapping("/testLong")
    public Long testLong() {
        Long a = 1111L;
        return a;
    }
}
