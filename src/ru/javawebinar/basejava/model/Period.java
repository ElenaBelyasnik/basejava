package ru.javawebinar.basejava.model;

import com.google.gson.annotations.JsonAdapter;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import ru.javawebinar.basejava.util.DateUtil;
import ru.javawebinar.basejava.util.GsonLocalDateAdapter;
import ru.javawebinar.basejava.util.LocalDateAdapter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class Period  implements Serializable {

    @JsonAdapter(GsonLocalDateAdapter.class)
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate startDate;
    @JsonAdapter(GsonLocalDateAdapter.class)
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate endDate;

    public Period() {
    }

    public Period(int startYear, Month startMonth){
        this(DateUtil.of(startYear, startMonth), DateUtil.NOW);
    }

    public Period(int startYear, Month startMonth, int endYear, Month endMonth) {
        this(DateUtil.of(startYear, startMonth), DateUtil.of(endYear, endMonth));
    }

    public Period(LocalDate startDate, LocalDate endDate) {
        Objects.requireNonNull(startDate, "startDate must not be null");
        Objects.requireNonNull(endDate, "endDate must not be null");
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Period period = (Period) o;

        if (!startDate.equals(period.startDate)) return false;
        return endDate.equals(period.endDate);
    }

    @Override
    public int hashCode() {
        int result = startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Period{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
