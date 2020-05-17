package net.blogsv.calculator_nts.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import net.blogsv.calculator_nts.lib.Cal;

/**
 * Created by quang on 5/16/2020.
 * Website: https://blogsv.net
 */
public class MainViewModel extends AndroidViewModel {
    Cal cal;
    MutableLiveData<Double> result;

    public MainViewModel(@NonNull Application application) {
        super(application);
        cal = new Cal();
        result = new MutableLiveData<>();


    }


    public MutableLiveData<Double> getResult() {
        return result;
    }

    public void calMath(String str) {
        if (!str.isEmpty()) {
            result.postValue(Math.ceil(cal.evaluate(str)*1000000)/1000000);
        } else {
            result.postValue(0.0);
        }
    }
}
