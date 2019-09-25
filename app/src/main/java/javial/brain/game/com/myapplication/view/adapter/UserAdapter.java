package javial.brain.game.com.myapplication.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import javial.brain.game.com.myapplication.R;
import javial.brain.game.com.myapplication.databinding.ItemUserBinding;
import javial.brain.game.com.myapplication.model.User;
import javial.brain.game.com.myapplication.viewmodel.UserViewMOdel;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.CustomHolder> {

    private ArrayList<UserViewMOdel> arrayList = new ArrayList<>();
    private LayoutInflater layoutInflater ;

    public UserAdapter(ArrayList<UserViewMOdel> users) {
        this.arrayList = users;
    }


    @NonNull
    @Override
    public CustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(layoutInflater==null)
            layoutInflater = LayoutInflater.from(parent.getContext());

        ItemUserBinding itemUserBinding = DataBindingUtil.inflate(layoutInflater,R.layout.item_user,parent,false);

        return new CustomHolder(itemUserBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class CustomHolder extends RecyclerView.ViewHolder{

        private ItemUserBinding itemUserBinding;

        public CustomHolder(ItemUserBinding itemUserBinding) {
            super(itemUserBinding.getRoot());
            this.itemUserBinding = itemUserBinding;
        }

        private void bind(UserViewMOdel userViewMOdel){
            this.itemUserBinding.setItem(userViewMOdel);
            this.itemUserBinding.executePendingBindings();
        }

        public ItemUserBinding getItemUserBinding() {
            return itemUserBinding;
        }
    }
}
