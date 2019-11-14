package task;

import nl.garvelink.iban.Modulo97;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api")
public class Controller {

    @GetMapping("checkList")
    public List<String> checkIBANList(@RequestParam(value = "List of IBAN") List<String> list){
        IntStream.range(0, list.size()).forEach(i -> list.set(i, list.get(i)+";"+ Modulo97.verifyCheckDigits(list.get(i))));
        return list;
    }

//    @GetMapping("checkStringL")
//    public List<String> checkIBANString(@RequestParam(value = "List of IBANS as 1 string ") String str){
//        List<String> strings = new ArrayList<>(Arrays.asList(str.split("/r")));
//        IntStream.range(0, strings.size()).forEach(i -> strings.set(i, strings.get(i)+";"+ Modulo97.verifyCheckDigits(strings.get(i))));
//        return strings;
//    }
}
