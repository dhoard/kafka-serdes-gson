/*
 * Copyright 2022 Douglas Hoard
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.dhoard.kafka.serde.gson;

import com.google.gson.JsonObject;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.charset.StandardCharsets;
import java.util.Map;

class JsonObjectSerializer implements Serializer<JsonObject> {

    public void configure(Map<String, ?> configs, boolean isKey) {
        // DO NOTHING
    }

    public byte[] serialize(String topic, JsonObject data) {
        return serialize(topic, null, data);
    }

    // Headers are not serialized
    public byte[] serialize(String topic, Headers headers, JsonObject data) {
        if (data == null) {
            return null;
        }

        try {
            return data.toString().getBytes(StandardCharsets.UTF_8);
        } catch (Throwable t) {
            throw new SerializationException(t);
        }
    }

    public void close() {
        // DO NOTHING
    }
}

