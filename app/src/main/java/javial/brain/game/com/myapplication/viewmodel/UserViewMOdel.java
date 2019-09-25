package javial.brain.game.com.myapplication.viewmodel;

import android.content.Context;
import android.view.ViewParent;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import javial.brain.game.com.myapplication.model.User;
import javial.brain.game.com.myapplication.view.adapter.UserAdapter;

public class UserViewMOdel extends BaseObservable {
    private String name;
    private String phone;
    private Context context;
    private MutableLiveData<ArrayList<UserViewMOdel>> arrayListMutableLiveData = new MutableLiveData<>();
    private ArrayList<UserViewMOdel> userHolder = new ArrayList<>();

    public UserViewMOdel(MutableLiveData<ArrayList<UserViewMOdel>> arrayListMutableLiveData) {
        this.arrayListMutableLiveData = arrayListMutableLiveData;
    }

    public UserViewMOdel(User user) {
        this.name = user.getName();
        this.phone = user.getPhone();
    }

    public UserViewMOdel(Context context) {
        this.context = context;

        // connect to Api Service
        for(int i = 0; i<5; i++){
            User user = new User("Abouzar: " + i , "77885567");
            UserViewMOdel userViewMOdel = new UserViewMOdel(user);
            userHolder.add(userViewMOdel);
        }
        arrayListMutableLiveData.setValue(userHolder);

    }

    @BindingAdapter("bind:recyclerUser")
    public static void recyclerViewBinder(final RecyclerView recyclerView, final MutableLiveData<ArrayList<UserViewMOdel>> arrayListMutableLiveData){
        arrayListMutableLiveData.observe((LifecycleOwner) recyclerView.getContext(), new Observer<ArrayList<UserViewMOdel>>() {
            @Override
            public void onChanged(ArrayList<UserViewMOdel> userViewMOdels) {
                UserAdapter userAdapter = new UserAdapter(userViewMOdels);
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(),LinearLayoutManager.VERTICAL,false));
                recyclerView.setAdapter(userAdapter);
            }
        });
    }

    @Bindable
    public MutableLiveData<ArrayList<UserViewMOdel>> getArrayListMutableLiveData() {
        return arrayListMutableLiveData;
    }

    public void setArrayListMutableLiveData(MutableLiveData<ArrayList<UserViewMOdel>> arrayListMutableLiveData) {
        this.arrayListMutableLiveData = arrayListMutableLiveData;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        notifyPropertyChanged(BR.phone);
    }
}
