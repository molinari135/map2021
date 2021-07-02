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

    private List<Item> list = new ArrayList<>();

    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }

    public void add(Item o) {
        list.add(o);
    }

    public void remove(Item o) {
        list.remove(o);
    }
}