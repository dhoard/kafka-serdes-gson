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
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class JsonObjectSerde implements Serde<JsonObject> {

    private Serializer<JsonObject> serializer;
    private Deserializer<JsonObject> deserializer;

    public JsonObjectSerde() {
        serializer = new JsonObjectSerializer();
        deserializer = new JsonObjectDeserializer();
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // DO NOTHING
    }

    @Override
    public Serializer<JsonObject> serializer() {
        return serializer;
    }

    @Override
    public Deserializer<JsonObject> deserializer() {
        return deserializer;
    }
}
