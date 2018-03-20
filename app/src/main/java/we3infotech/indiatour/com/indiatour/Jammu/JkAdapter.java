package we3infotech.indiatour.com.indiatour.Jammu;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import we3infotech.indiatour.com.indiatour.R;

/**
 * Created by imakash on 3/18/2018.
 */


public class JkAdapter extends RecyclerView.Adapter<JkAdapter.MyViewHolder> {
    private Context co;
    private ArrayList<JkList> jkLists;
    private JkAdapter.OnItemClickListener mListener;

    public JkAdapter(Context context, ArrayList<JkList> jkListArrayList) {
        this.co = context;
        this.jkLists = jkListArrayList;
    }

    @Override
    public JkAdapter.MyViewHolder  onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(co).inflate(R.layout.model, parent, false);
        return new JkAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(JkAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(jkLists.get(position).getName());
        holder.tvPrice.setText(jkLists.get(position).getPrice());
        holder.desctxt.setText(jkLists.get(position).getDescription());
        holder.minorder.setText(jkLists.get(position).getMinOrder());

        Glide.with(co)
                .load(jkLists.get(position).getImageUrl())
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(holder.ivFood);
//        holder.btnCallNow.setOnClickListener(new NorthAdapter.OnButtonClick(position));


    }

    @Override
    public int getItemCount() {
        return jkLists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivFood;
        private TextView tvName, tvPrice,minorder,desctxt;
        private Button btnCallNow;

        public MyViewHolder(View itemView) {
            super(itemView);
            ivFood = (ImageView) itemView.findViewById(R.id.ivFood);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvPrice = (TextView) itemView.findViewById(R.id.tvPrice);
            desctxt = (TextView) itemView.findViewById(R.id.descTxt);
            minorder = (TextView) itemView.findViewById(R.id.minOrder);
            // btnCallNow = (Button) itemView.findViewById(R.id.btnCallNow);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.OnItemClick(getAdapterPosition());
                }
            });
        }
    }

    public class OnButtonClick implements View.OnClickListener {
        private int mPosition;

        public OnButtonClick(int position) {
            this.mPosition = position;
        }

        @Override
        public void onClick(View view) {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_NO_USER_ACTION);
            callIntent.setData(Uri.parse("tel://7974553889"));
            co.startActivity(callIntent);
        }


    }
    public void setOnClickListner(JkAdapter.OnItemClickListener onClickListner) {
        mListener = onClickListner;
    }

    public interface OnItemClickListener {
        void OnItemClick(int position);
    }
}
