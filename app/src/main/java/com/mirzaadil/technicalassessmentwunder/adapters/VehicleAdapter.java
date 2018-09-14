package com.mirzaadil.technicalassessmentwunder.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mirzaadil.technicalassessmentwunder.R;
import com.mirzaadil.technicalassessmentwunder.models.PlacemarksItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Mirza Adil on 9/09/2018.
 * <p>
 * This is a All Category  adapter class .
 * This class will feature the implementation of the Recycler Adapter for all category recycler.
 */

public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.VehicleViewHolder> {
    private List<PlacemarksItem> allCategoryList;
    private Context context;


    public VehicleAdapter(List<PlacemarksItem> allCategoryList, Context context) {
        this.allCategoryList = allCategoryList;
        this.context = context;
    }


    @NonNull
    @Override
    public VehicleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vehicle_list, parent, false);
        return new VehicleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final VehicleViewHolder holder, final int position) {

        holder.vehicle_address.setText(context.getResources().getString(R.string.address) + " " + allCategoryList.get(position).getAddress());
        holder.vehicle_name.setText(context.getResources().getString(R.string.name) + " " + allCategoryList.get(position).getName());
        holder.vehicle_engine.setText(context.getResources().getString(R.string.engine) + " " + allCategoryList.get(position).getEngineType());
        holder.vehicle_interior.setText(context.getResources().getString(R.string.interior) + " " + allCategoryList.get(position).getInterior());
        holder.vehicvle_fuel.setText(context.getResources().getString(R.string.fuel) + " " + String.valueOf(allCategoryList.get(position).getFuel()));
        holder.vehicle_exterior.setText(context.getResources().getString(R.string.exterior) + " " + allCategoryList.get(position).getExterior());
        holder.vehicle_vin.setText(context.getResources().getString(R.string.vin) + " " + allCategoryList.get(position).getVin());


        holder.vehicle_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context,"Click",Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return allCategoryList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    class VehicleViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.vehicle_name)
        TextView vehicle_name;
        @BindView(R.id.vehicle_engineType)
        TextView vehicle_engine;
        @BindView(R.id.vehicle_interior)
        TextView vehicle_interior;
        @BindView(R.id.vehicle_fuel)
        TextView vehicvle_fuel;
        @BindView(R.id.vehicle_exterior)
        TextView vehicle_exterior;
        @BindView(R.id.vehicle_vin)
        TextView vehicle_vin;
        @BindView(R.id.vehicle_address)
        TextView vehicle_address;


        public VehicleViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}

