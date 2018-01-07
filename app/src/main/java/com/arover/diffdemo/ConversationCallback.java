package com.arover.diffdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author arover
 *         created at 06/01/2018 17:28
 */
public class ConversationCallback extends DiffUtil.Callback {

    public static final String KEY_AVATAR_URL = "KEY_AVATAR_URL";
    public static final String KEY_USERNAME = "KEY_USERNAME";
    public static final String KEY_CONTENT_PREVIEW = "KEY_CONTENT_PREVIEW";
    private final List<Conversation> oldList;
    private final List<Conversation> newList;

    public ConversationCallback(List<Conversation> oldList, List<Conversation> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override public int getOldListSize() {
        return oldList == null ? 0: oldList.size();
    }

    @Override public int getNewListSize() {
        return newList == null ? 0: newList.size();
    }

    @Override public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getId() == newList.get(newItemPosition).getId();
    }

    @Override public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).isContentSameAs(newList.get(newItemPosition));
    }

    @Nullable @Override public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        Conversation newItem = newList.get(newItemPosition);
        Conversation oldeItem = oldList.get(oldItemPosition);
        Bundle diffBundle = new Bundle();

        if(!Objects.equals(newItem.getAvatarUrl(), oldeItem.getAvatarUrl())){
            diffBundle.putString(KEY_AVATAR_URL, newItem.getAvatarUrl());
        }

        if(!Objects.equals(newItem.getUsername(), oldeItem.getUsername())){
            diffBundle.putString(KEY_USERNAME, newItem.getUsername());
        }

        if(!Objects.equals(newItem.getContentPreview(), oldeItem.getContentPreview())){
            diffBundle.putString(KEY_CONTENT_PREVIEW, newItem.getContentPreview());
        }
        if(diffBundle.size()==0){
            return null;
        }

        return diffBundle;
//        return super.getChangePayload(oldItemPosition,newItemPosition);
    }


}
