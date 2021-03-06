/*
 * Copyright (C) 2014 Arpit Khurana <arpitkh96@gmail.com>, Vishal Nehra <vishalmeham2@gmail.com>
 *
 * This file is part of Amaze File Manager.
 *
 * Amaze File Manager is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.amaze.filemanager.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amaze.filemanager.R;

import java.util.ArrayList;
import java.util.zip.ZipEntry;

public class ZipAdapter extends ArrayAdapter<ZipEntry> {
    Context c;
    Drawable folder, unknown;
    ArrayList<ZipEntry> enter;

    public ZipAdapter(Context c, int id, ArrayList<ZipEntry> enter) {
        super(c, id, enter);
        this.enter = enter;
        this.c = c;
        folder = c.getResources().getDrawable(R.drawable.ic_grid_folder1);
        unknown = c.getResources().getDrawable(R.drawable.ic_doc_generic_am);
    }

    private class ViewHolder {
        ImageView imageView;
        TextView txtTitle;
        TextView txtDesc;
        TextView date;
        RelativeLayout rl;

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        final ZipEntry rowItem = enter.get(position);

        View view;
        final int p = position;
        if (convertView == null) {
            int i = R.layout.simplerow;

            LayoutInflater mInflater = (LayoutInflater) c
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(i, null);
            final ViewHolder vholder = new ViewHolder();

            vholder.txtTitle = (TextView) view.findViewById(R.id.firstline);
            vholder.imageView = (ImageView) view.findViewById(R.id.icon);
            vholder.rl = (RelativeLayout) view.findViewById(R.id.second);

            view.setTag(vholder);

        } else {
            view = convertView;

        }
        final ViewHolder holder = (ViewHolder) view.getTag();
        holder.txtTitle.setText(rowItem.getName());
        if (rowItem.isDirectory()) {
            holder.imageView.setImageDrawable(folder);
        } else {
            holder.imageView.setImageDrawable(unknown);
        }
        holder.rl.setOnClickListener(new View.OnClickListener() {

            public void onClick(View p1) {
                // TODO: Implement this method
            }
        });
        return view;
    }
}
