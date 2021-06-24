/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package type;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giaco
 */
public class Inventory {

    private List<VarObject> list = new ArrayList<>();

    public List<VarObject> getList() {
        return list;
    }

    public void setList(List<VarObject> list) {
        this.list = list;
    }

    public void add(VarObject o) {
        list.add(o);
    }

    public void remove(VarObject o) {
        list.remove(o);
    }
}