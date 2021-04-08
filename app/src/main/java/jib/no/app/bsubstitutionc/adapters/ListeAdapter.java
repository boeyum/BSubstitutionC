package jib.no.app.bsubstitutionc.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import jib.no.app.bsubstitutionc.R;

public class ListeAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<String> objects;

    private class ViewHolder {
        TextView textView1;
    }

    public ListeAdapter(Context context, ArrayList<String> objects) {
        inflater = LayoutInflater.from(context);
        this.objects = objects;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    public String getItem(int position) {
        return objects.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ListeAdapter.ViewHolder holder = null;
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.listelayout, null);
            holder = new ListeAdapter.ViewHolder();
            holder.textView1 = (TextView) convertView.findViewById(R.id.listelinje);
            convertView.setTag(holder);
        } else {
            holder = (ListeAdapter.ViewHolder) convertView.getTag();
        }
        String linje = objects.get(position);
        if(linje != null) {
            holder.textView1.setText(linje);
        }
        return convertView;
    }
}
