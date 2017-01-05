package com.example.jsonquery.filter;

import com.example.jsonquery.filter.servlet.FilterResponseWrapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.thisptr.jackson.jq.JsonQuery;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class JsonQueryFilter implements Filter {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String jsonQuery = httpRequest.getHeader("jsonQuery");

        FilterResponseWrapper httpServletResponseWrapper = new FilterResponseWrapper(httpResponse);

        chain.doFilter(request, httpServletResponseWrapper);

        String jsonResponse = applyJsonQuery(jsonQuery, httpServletResponseWrapper);

        response.getOutputStream().write(jsonResponse.getBytes());
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }

    private String applyJsonQuery(final String jsonQuery, final FilterResponseWrapper httpServletResponseWrapper) throws IOException {

        String jsonResponse = httpServletResponseWrapper.toString();

        if (StringUtils.isNotEmpty(jsonQuery)) {

            JsonQuery query = JsonQuery.compile(jsonQuery);

            JsonNode jsonNode = mapper.readValue(jsonResponse.getBytes(), JsonNode.class);

            List<JsonNode> nodes = query.apply(jsonNode);

            jsonResponse = nodes.size() == 1 ? nodes.get(0).toString() : nodes.toString();
        }

        return jsonResponse;
    }

    @Override
    public void destroy() {
    }
}
