package org.calculator;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "calculatorBean")
public class Calculator {

    private int _param1;
    private int _param2;
    private String _param3;
    private String _result;
    
    public Calculator() {
    }
    
    public int getParam1() {
        return _param1;
    }

    public void setParam1(int param1) {
        _param1 = param1;
    }

    public int getParam2() {
        return _param2;
    }

    public void setParam2(int param2) {
        _param2 = param2;
    }
    
    public String getParam3() {
        return _param3;
    }

    public void setParam3(String param3) {
        _param3 = param3;
    }

    public String getResult() {
        return _result;
    }
    public void calculate() {
        if (_param3.equals("+")) add();
        else if (_param3.equals("-")) subtract();
        else if (_param3.equals("*")) multiply();
        else divide();
    }

    public void add(){
        _result = Integer.toString(_param1 + _param2);
    }

    public void subtract(){
        _result = Integer.toString(_param1 - _param2);
    }

    public void multiply(){
        _result = Integer.toString(_param1 * _param2);
    }

    public void divide(){
        _result = _param2 == 0 ? "n/a" : Double.toString(_param1 / (double)_param2);
    }
}