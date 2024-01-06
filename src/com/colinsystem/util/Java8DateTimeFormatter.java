package com.colinsystem.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 自定义格式化
 * @author FrancisGaozhu
 * 2023-11-22 13:52:51
 */
public class Java8DateTimeFormatter extends SimpleTagSupport {

    /**
     * 时间格式化表达式
     */
    private String pattern;
    /**
     * 需要格式化的时间
     */
    private LocalDateTime time;

    @Override
    public void doTag() throws JspException, IOException {
        String formatResult = this.time.format(DateTimeFormatter.ofPattern(this.pattern));
        getJspContext().getOut().print(formatResult);
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
