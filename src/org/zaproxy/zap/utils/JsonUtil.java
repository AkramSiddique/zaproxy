/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2018 The ZAP Development Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.zaproxy.zap.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONSerializer;

public final class JsonUtil {
	
	private JsonUtil() {
	}

	public static String getJsonFriendlyString(String value) {
		try {
			JSONSerializer.toJSON(value);
			// Its valid JSON so escape
			return "'" + value + "'";
		} catch (JSONException e) {
			// Its not a valid JSON object so can add as is
			return value;
		}
	}
	
	
	public static List<String> toStringList(JSONArray array) {
		List<String> list = new ArrayList<String>();
		Iterator<?> iter = JSONArray.toCollection(array).iterator();
		while (iter.hasNext()) {
			list.add(iter.next().toString());
		}
		return list;
	}

}
