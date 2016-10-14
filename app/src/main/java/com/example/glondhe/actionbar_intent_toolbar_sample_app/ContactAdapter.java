package com.example.glondhe.actionbar_intent_toolbar_sample_app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by glondhe on 10/11/16.
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private List<Contacts> mContact;
    private Context mContext;

    public ContactAdapter(Context context, List<Contacts> contacts) {
        mContact = contacts;
        mContext = context;
    }

    private Context getContext() {
        return mContext;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;
        public TextView numberTextView;
        private Context context;

        public ViewHolder(final Context context, View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
            numberTextView = (TextView) itemView.findViewById(R.id.contact_number);
            this.context =  context;

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:0377778888"));
                    context.startActivity(callIntent);
                    return true;
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String test = (String) nameTextView.getText();
                    Toast.makeText(context,test, Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //Inflate custom layout
        View contactView = layoutInflater.inflate(R.layout.activity_list, parent, false);

        //Return new Holder Instance
        ViewHolder viewHolder = new ViewHolder(context, contactView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ContactAdapter.ViewHolder viewHolder, int position) {

        Contacts contacts = mContact.get(position);

        TextView textView = viewHolder.nameTextView;
        textView.setText(contacts.getName());

        TextView textView1 = viewHolder.numberTextView;
        textView1.setText(contacts.getNumber());
    }

    @Override
    public int getItemCount() {
        return mContact.size();
    }

}