package ru.javawebinar.basejava.util;

import ru.javawebinar.basejava.model.Organization;

public class HtmlUtil {
    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }
    public static String formatDates(Organization.Position position) {
        return DateUtil.format(position.getPeriod().getStartDate()) + " - "
                + DateUtil.format(position.getPeriod().getEndDate());
    }
}
