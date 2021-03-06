/*
 *     This file is part of Telegram Server
 *     Copyright (C) 2015  Aykut Alparslan KOÇ
 *
 *     Telegram Server is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Telegram Server is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.telegram.tl.L57.messages;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.TLObject;
import org.telegram.tl.TLVector;
import org.telegram.tl.APIContext;
import org.telegram.tl.L57.*;

public class AddChatUser extends TLObject {

    public static final int ID = 0xf9a0aa09;

    public int chat_id;
    public org.telegram.tl.TLInputUser user_id;
    public int fwd_limit;

    public AddChatUser() {
    }

    public AddChatUser(int chat_id, org.telegram.tl.TLInputUser user_id, int fwd_limit) {
        this.chat_id = chat_id;
        this.user_id = user_id;
        this.fwd_limit = fwd_limit;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        chat_id = buffer.readInt();
        user_id = (org.telegram.tl.TLInputUser) buffer.readTLObject(APIContext.getInstance());
        fwd_limit = buffer.readInt();
    }

    @Override
    public ProtocolBuffer serialize() {
        ProtocolBuffer buffer = new ProtocolBuffer(20);
        serializeTo(buffer);
        return buffer;
    }


    @Override
    public void serializeTo(ProtocolBuffer buff) {
        buff.writeInt(getConstructor());
        buff.writeInt(chat_id);
        buff.writeTLObject(user_id);
        buff.writeInt(fwd_limit);
    }


    public int getConstructor() {
        return ID;
    }
}