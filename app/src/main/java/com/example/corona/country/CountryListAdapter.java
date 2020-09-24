package com.example.corona.country;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.corona.R;

import java.util.List;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.ViewHolder> {

    List<CountryModel> countryLists;
    Frag2 context;

    public CountryListAdapter(List<CountryModel> countryLists, Frag2 frag2) {
        this.countryLists = countryLists;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_single_frag2, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CountryModel countryList = countryLists.get(position);
        holder.tvCountry.setText(" "+countryList.getCountryText());
        holder.tvActiveCases.setText("Active Cases: "+countryList.getActiveCasesText());
        holder.tvNewCases.setText("New Cases: "+countryList.getNewCasesText());
        holder.tvLastUpdate.setText(countryList.getLastUpdate());

    }

    @Override
    public int getItemCount() {
        return countryLists.size();
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
