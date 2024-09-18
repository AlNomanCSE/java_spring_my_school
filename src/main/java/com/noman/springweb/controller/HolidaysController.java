package com.noman.springweb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import com.noman.springweb.model.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;


@Slf4j
@Controller
public class HolidaysController {

//    @GetMapping("/holidays")
//    public String displayHolidays(@RequestParam(required = false) boolean festival, @RequestParam(required = false) boolean federal, Model model) {
//        model.addAttribute("festival", festival);
//        model.addAttribute("federal", federal);
    @GetMapping("/holidays/{display}")
     public String displayHolidays(@PathVariable String display, Model model) {
        if(null!=display && display.equals("all")) {
            model.addAttribute("festival",true);
            model.addAttribute("federal",true);
        } else if (null!=display && display.equals("federal")) {
            model.addAttribute("federal",true);
        } else if (null!=display && display.equals("festival")) {
            model.addAttribute("festival",true);
        }
        List<Holiday> holidays = Arrays.asList(
                // FESTIVAL holidays (religious and cultural)
                new Holiday("Feb 21", "Shaheed Day (Language Martyrs Day)", Holiday.Type.FESTIVAL),
                new Holiday("Apr 14", "Pohela Boishakh (Bengali New Year)", Holiday.Type.FESTIVAL),
                new Holiday("May 1", "Eid-ul-Fitr", Holiday.Type.FESTIVAL), // Date varies based on Islamic calendar
                new Holiday("Jul 10", "Eid-ul-Adha", Holiday.Type.FESTIVAL), // Date varies based on Islamic calendar
                new Holiday("Aug 15", "Janmashtami", Holiday.Type.FESTIVAL),
                new Holiday("Oct 24", "Durga Puja", Holiday.Type.FESTIVAL), // Date varies
                new Holiday("Dec 25", "Christmas Day", Holiday.Type.FESTIVAL),

                // FEDERAL holidays (national)
                new Holiday("Mar 26", "Independence Day", Holiday.Type.FEDERAL),
                new Holiday("Apr 17", "Shab-e-Barat", Holiday.Type.FEDERAL), // Date varies based on Islamic calendar
                new Holiday("Aug 15", "National Mourning Day", Holiday.Type.FEDERAL),
                new Holiday("Dec 16", "Victory Day", Holiday.Type.FEDERAL)
        );
        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(),
                    holidays.stream()
                            .filter(holiday -> holiday.getType().equals(type))
                            .collect(Collectors.toList())
            );
        }

        return "holidays.html";
    }

}
