package com.theqvd.android.client;

/**
 * Copyright 2009-2016 by theqvd.com trade mark of Qindel Formacion y Servicios SL
 * 
 * qvdclient is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * qvdclient is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 */

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.theqvd.android.xpro.Config;
import com.theqvd.client.jni.QvdProgressHandler;

public class ConnectionProgress implements QvdProgressHandler {
	static final String tag = Config.xvncbinary + "-ConnectionProgress-" +java.util.Map.Entry.class.getSimpleName();
	Activity activity;
	ConnectionProgress(Activity activity) {
		this.activity = activity;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void print_progress(String message) {
		Intent qvdclientActivity = new Intent(activity, QvdclientActivity.class);
		PendingIntent qvdclientActivityPI = PendingIntent.getActivity(activity, 0, qvdclientActivity, 0);

		NotificationManager mNotificationManager = (NotificationManager) activity.getSystemService(Context.NOTIFICATION_SERVICE);
		Notification notification = new Notification(R.drawable.icon, "QVD connection", System.currentTimeMillis());
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		notification.setLatestEventInfo(activity, message, message, qvdclientActivityPI);
		mNotificationManager.notify(Qvdconnection.connectnotify, notification);
		
	}

}
