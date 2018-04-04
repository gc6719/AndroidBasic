package org.master.android.androidbasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by Gururaj.C.M on 03-04-2018
 */

  class Model extends Observable {

    private List<Integer> mList ;

    Model() {
        mList = new ArrayList<Integer>(3){{add(0);add(0);add(0);}};
    }

      Integer getValueAtIndex (int index) throws ArrayIndexOutOfBoundsException {
        return mList.get(index);
    }

      void setValueAtIndex(int index) {
        this.mList.set(index,(this.mList.get(index)+1));
        setChanged();
        notifyObservers();
    }


}
