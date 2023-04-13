package me.mizab.studentmanagementsystem.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import me.mizab.studentmanagementsystem.R;
import me.mizab.studentmanagementsystem.general.DeleteActivity;
import me.mizab.studentmanagementsystem.general.DisplayMoreInfoActivity;
import me.mizab.studentmanagementsystem.general.UpdateActivity;
import me.mizab.studentmanagementsystem.model.StudInfo;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<StudInfo> studInfoList;
    private String activity;

    public RecyclerViewAdapter(Context context, List<StudInfo> studInfoList, String activity) {
        this.context = context;
        this.studInfoList = studInfoList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        StudInfo studInfo = studInfoList.get(position);

        String gender_text = studInfo.getGender();
        int gender_id;
        int holder_background;

        if(gender_text.equals("Male")) {
            gender_id = R.drawable.male;
            holder_background = R.drawable.info_card_m;
        } else if (gender_text.equals("Female")){
            gender_id = R.drawable.female;
            holder_background = R.drawable.info_card_f;
        } else {
            gender_id = R.drawable.other;
            holder_background = R.drawable.info_card_o;
        }

        holder.itemView.setBackground(AppCompatResources.getDrawable(context, holder_background));
        holder.studGender.setImageDrawable(AppCompatResources.getDrawable(context, gender_id));
        holder.studName.setText("Name - " + studInfo.getName());
        holder.studRollNo.setText("Roll No - " + studInfo.getRollNo());
        holder.studEnrollNo.setText("Enrollment No - " + studInfo.getEnrollNo());
    }

    @Override
    public int getItemCount() {
        return studInfoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView studGender;
        public TextView studName;
        public TextView studRollNo;
        public TextView studEnrollNo;
        public Button studInfoBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            studGender = itemView.findViewById(R.id.list_gender);
            studName = itemView.findViewById(R.id.list_name);
            studRollNo = itemView.findViewById(R.id.list_roll_no);
            studEnrollNo = itemView.findViewById(R.id.list_enrollment_no);
            studInfoBtn = itemView.findViewById(R.id.list_more_info);
            Drawable drawable = null;

            switch (activity) {
                case "browse":
                    drawable = AppCompatResources.getDrawable(context, R.drawable.more);
                    break;
                case "update":
                    drawable = AppCompatResources.getDrawable(context, R.drawable.update);
                    break;
                case "delete":
                    drawable = AppCompatResources.getDrawable(context, R.drawable.remove);
                    break;
            }
            studInfoBtn.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
            studInfoBtn.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = this.getAdapterPosition();
            StudInfo studInfo = studInfoList.get(position);
            int id = studInfo.getId();

            switch (activity) {
                case "browse": {
                    Intent intent = new Intent(context, DisplayMoreInfoActivity.class);
                    intent.putExtra("Rid", String.valueOf(id));
                    context.startActivity(intent);
                    break;
                }
                case "update": {
                    Intent intent = new Intent(context, UpdateActivity.class);
                    intent.putExtra("Rid", String.valueOf(id));
                    context.startActivity(intent);
                    break;
                }
                case "delete": {
                    Intent intent = new Intent(context, DeleteActivity.class);
                    intent.putExtra("Rid", String.valueOf(id));
                    context.startActivity(intent);
                    break;
                }
            }

        }
    }
}
