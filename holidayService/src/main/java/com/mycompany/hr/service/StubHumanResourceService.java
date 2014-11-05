package com.mycompany.hr.service;

import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by obalaban on 11/5/2014.
 */
@Service
public class StubHumanResourceService implements HumanResourceService {

    public void bookHoliday(Date startDate, Date endDate, String name) {
        System.out.println("Booking holiday for [" + startDate + "-" + endDate + "] for [" + name + "]");
    }
}
