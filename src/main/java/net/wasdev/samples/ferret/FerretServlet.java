/*******************************************************************************
 * Copyright (c) 2014 IBM Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package net.wasdev.samples.ferret;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.*;
import java.util.Date;
import net.wasdev.samples.ferret.html.Element;
import net.wasdev.samples.ferret.html.Element.ElementType;
import net.wasdev.samples.ferret.html.Page;
import net.wasdev.samples.ferret.html.Table;

@WebServlet("/*")
public final class FerretServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
            IOException {
        writeResponse(request, response);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println("A GET request has been made to this servlet at " + dateFormat.format(date));
    }

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        writeResponse(request, response);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println("A POST request has been made to this servlet at " + dateFormat.format(date));
    }

    @Override
    protected void doPut(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
            IOException {
        writeResponse(request, response);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println("A PUT request has been made to this servlet at " + dateFormat.format(date));
    }

    @Override
    protected void doDelete(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        writeResponse(request, response);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println("A DELETE request has been made to this servlet at " + dateFormat.format(date));
    }

    private FerretData getFerretData(final HttpServletRequest httpServletRequest) {
        return new FerretData(getServletConfig(), getServletContext(), httpServletRequest);
    }

    private void writeResponse(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        Map<String, Object> data = getFerretData(request).getAsMap();
        Table table = new Table(data);
        PrintWriter writer = response.getWriter();
        writer.println(new Page().withBodyElement(new Element(ElementType.DIV).withInnerHtml(table.toHtml())).toHtml());
    }

}
