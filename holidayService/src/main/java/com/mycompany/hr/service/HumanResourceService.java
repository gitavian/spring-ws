package com.mycompany.hr.service;

import java.util.Date;

/**
 * Created by obalaban on 11/5/2014.
 */
public interface HumanResourceService {
    void bookHoliday(Date startDate, Date endDate, String name);
}
