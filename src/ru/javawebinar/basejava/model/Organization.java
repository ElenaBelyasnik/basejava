package ru.javawebinar.basejava.model;

import java.util.List;
import java.util.Objects;

public class Organization {
    private final Link webSite;
    private final List<Period> periods;


    public Organization(String name, String url, List<Period> periods) {
        this.webSite = new Link(name, url);
        Objects.requireNonNull(webSite, "webSite must not be null");
        this.periods = periods;
    }

    public Link getWebSite() {
        return webSite;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (!webSite.equals(that.webSite)) return false;
        return periods.equals(that.periods);
    }

    @Override
    public int hashCode() {
        int result = webSite.hashCode();
        result = 31 * result + periods.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "webSite=" + webSite +
                ", periods=" + periods +
                '}';
    }
}
