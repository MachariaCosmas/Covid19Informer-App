package com.example.corona.world;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.corona.R;
import com.example.corona.world.WorldModel;

import java.util.List;

public class WorldAdapter extends RecyclerView.Adapter<WorldAdapter.ViewHolder> {

    List<WorldModel> worldLists;
    Frag1 context;

    public WorldAdapter(List<WorldModel> worldLists, Frag1 frag1) {
        this.worldLists = worldLists;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_single_frag1, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WorldModel worldList =worldLists.get(position);
        holder.tvCountry.setText(" "+worldList.getCountryText());
        holder.tvActiveCases.setText("Active Cases: "+worldList.getActiveCasesText());
        holder.tvNewCases.setText("New Cases: "+worldList.getNewCasesText());
        holder.tvLastUpdate.setText(worldList.getLastUpdate());

    }

    @Override
    public int getItemCount() {
        return worldLists.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvCountry,tvActiveCases,tvNewCases,tvLastUpdate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCountry = (TextView) itemView.findViewById(R.id.listCountry);
            tvActiveCases = (TextView) itemView.findViewById(R.id.listActive);
            tvNewCases = (TextView) itemView.findViewById(R.id.listNewCases);
            tvLastUpdate = (TextView) itemView.findViewById(R.id.listLastUpdate);
        }
    }
}
