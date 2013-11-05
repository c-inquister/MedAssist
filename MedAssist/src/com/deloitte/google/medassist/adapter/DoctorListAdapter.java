package com.deloitte.google.medassist.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.deloitte.google.medassist.R;
import com.deloitte.google.medassist.data.Doctor;

public class DoctorListAdapter extends CustomBaseArrayAdapter<Doctor>{

    DoctorCallButtonClickListener mListItemCallButtonClickListener;

    public interface DoctorCallButtonClickListener {
        public void onCallClicked(int position);
    }

    public DoctorListAdapter(Context context, List<Doctor> list, DoctorCallButtonClickListener listener) {
        super(context, list);
        mListItemCallButtonClickListener = listener;
    }

    public DoctorListAdapter(Context context, int textViewResourceId, List<Doctor> list) {
        super(context, textViewResourceId, list);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ViewHolder viewHolder;

        if (v == null) {
            v = mInflater.inflate(R.layout.doctor_search_list_item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) v.findViewById(R.id.name);
            viewHolder.specialization = (TextView) v.findViewById(R.id.specialization);
            viewHolder.area = (TextView) v.findViewById(R.id.area);
            viewHolder.callButton = (ImageButton) v.findViewById(R.id.btn_call);
            v.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) v.getTag();
        }

        Doctor doc = getItem(position);

        viewHolder.name.setText(doc.name);
        viewHolder.specialization.setText(doc.specialisation);
        viewHolder.area.setText(doc.area);
        viewHolder.callButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(mListItemCallButtonClickListener!=null) {
                    mListItemCallButtonClickListener.onCallClicked(position);
                }
            }
        });
        return v;
    }

    static class ViewHolder {
        TextView name;
        TextView specialization;
        TextView area;
        ImageButton callButton;
    }

}
