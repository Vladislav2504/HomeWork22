package by.tms.web.servlet;

import by.tms.entity.Operation;
import by.tms.service.CalculatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CalculatorService calculatorService = new CalculatorService();
		Operation operation = new Operation();
		operation.setNum1(Double.parseDouble(req.getParameter("num1")));
		operation.setNum2(Double.parseDouble(req.getParameter("num2")));
		operation.setOperation(req.getParameter("operation"));
		operation = calculatorService.calculate(operation);
		resp.getWriter().write("result: " + operation);
	}
}
