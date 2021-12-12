/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.io.Serializable;

public class Result implements Serializable {
    private int result;

    public Result(int result) {
        this.result = result;
    }
public Result(){
    
}
    public void setResult(int result) {
        this.result = result;
    }
    
    public int getResult() { return result; }
}


