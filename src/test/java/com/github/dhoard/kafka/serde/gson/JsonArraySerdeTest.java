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

import com.google.gson.JsonArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonArraySerdeTest {

    private JsonArraySerde jsonArraySerde;

    @BeforeEach
    public void setUp() {
        jsonArraySerde = new JsonArraySerde();
    }

    @Test
    public void testNullJsonArray() {
        JsonArray e = null;
        byte[] bytes = jsonArraySerde.serializer().serialize(null, e);
        JsonArray a = jsonArraySerde.deserializer().deserialize(null, bytes);

        assertEquals(e, a);
    }

    @Test
    public void testEmptyJsonArray() {
        JsonArray e = new JsonArray();
        byte[] bytes = jsonArraySerde.serializer().serialize(null, e);
        JsonArray a = jsonArraySerde.deserializer().deserialize(null, bytes);

        assertEquals(e, a);
    }

    @Test
    public void testJsonArray() {
        JsonArray e = new JsonArray();
        e.add(123);
        byte[] bytes = jsonArraySerde.serializer().serialize(null, e);
        JsonArray a = jsonArraySerde.deserializer().deserialize(null, bytes);

        assertEquals(e, a);
    }
}
