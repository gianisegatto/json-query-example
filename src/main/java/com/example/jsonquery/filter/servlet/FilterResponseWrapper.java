package com.example.jsonquery.filter.servlet;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class FilterResponseWrapper extends HttpServletResponseWrapper {

    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private FilterServletOutputStream filterOutput;

    public FilterResponseWrapper(final HttpServletResponse response) {
        super(response);
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        if (filterOutput == null) {
            filterOutput = new FilterServletOutputStream(bos);
        }
        return filterOutput;
    }

    public String toString() {
        return new String(toByteArray());
    }

    private byte[] toByteArray() {
        byte[] ret = bos.toByteArray();
        bos.reset();
        return ret;
    }
}