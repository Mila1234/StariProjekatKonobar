package com.example.marija.restoranstariprojekat.spiner;

import android.content.Context;
import android.widget.ArrayAdapter;

public class MySpinnerAdapter extends ArrayAdapter<String> {

    private Context mContext;
   // private String tittle;
    //private String subtittle;

    private Boolean showUndefined;

    public MySpinnerAdapter(Boolean su, Context context, int textViewResourceId, String[] value) {
  super(context, textViewResourceId,value);
  // TODO Auto-generated constructor stub
        mContext = context;
        showUndefined = su;

 }


    public int getStartPosition(){
        int count = super.getCount();

        return count>0 ? count-1 : count ;

    }

  @Override
 public int getCount() {
	  
  // TODO Auto-generated method stub
  int count = super.getCount();

      if (showUndefined){
          return count;
      }else {
          return count > 0 ? count - 1 : count;
      }
  
  
 }


  /*  @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        return getCustomView(position, convertView, parent);
    }*/
/*
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        return getCustomView(position, convertView, parent);
    }



    public View getCustomView(int position, View convertView, ViewGroup parent) {
// TODO Auto-generated method stub
// return super.getView(position, convertView, parent);


        LayoutInflater inflater =
                ( LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.customspinneritem, null);
            holder = new ViewHolder();
            holder.txt01 = (TextView) convertView.findViewById(R.id.TextView01);
            holder.txt02 = (TextView) convertView.findViewById(R.id.TextView02);

            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();
        }

        holder.txt01.setText("My Library");
        holder.txt02.setText("ALL MUSIC");

        return convertView;
    }
    class ViewHolder {
        TextView txt01;
        TextView txt02;
    }
*/


}