package cn.wildfire.chat.conversationlist.viewholder;

import android.view.View;

import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import cn.wildfire.chat.ChatManagerHolder;
import cn.wildfire.chat.GlideApp;
import cn.wildfire.chat.annotation.ConversationInfoType;
import cn.wildfire.chat.annotation.EnableContextMenu;
import cn.wildfirechat.chat.R;
import cn.wildfirechat.model.Conversation;
import cn.wildfirechat.model.ConversationInfo;
import cn.wildfirechat.model.GroupInfo;

@ConversationInfoType(type = Conversation.ConversationType.Group, line = 0)
@EnableContextMenu
public class GroupConversationViewHolder extends ConversationViewHolder {

    public GroupConversationViewHolder(Fragment fragment, RecyclerView.Adapter adapter, View itemView) {
        super(fragment, adapter, itemView);
    }

    @Override
    protected void onBindConversationInfo(ConversationInfo conversationInfo) {
        GroupInfo groupInfo = ChatManagerHolder.gChatManager.getGroupInfo(conversationInfo.conversation.target, false);
        if (groupInfo != null) {
            GlideApp
                    .with(fragment)
                    .load(groupInfo.portrait)
                    .placeholder(R.mipmap.ic_group_cheat)
                    .transforms(new CenterCrop(), new RoundedCorners(10))
                    .into(portraitImageView);
            //群昵称
            nameTextView.setText(groupInfo.name);
        }
    }

}