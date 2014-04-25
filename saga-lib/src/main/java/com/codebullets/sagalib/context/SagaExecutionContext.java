/*
 * Copyright 2013 Stefan Domnanovits
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.codebullets.sagalib.context;

import com.codebullets.sagalib.Saga;

/**
 * Execution context used in the saga lib.
 */
public class SagaExecutionContext implements CurrentExecutionContext {
    private boolean dispatchingStopped;
    private Object message;
    private Saga saga;

    /**
     * {@inheritDoc}
     */
    @Override
    public void stopDispatchingCurrentMessageToHandlers() {
        dispatchingStopped = true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean dispatchingStopped() {
        return dispatchingStopped;
    }

    @Override
    public Object message() {
        return message;
    }

    @Override
    public Saga saga() {
        return saga;
    }

    @Override
    public void setMessage(final Object message) {
        this.message = message;
    }

    @Override
    public void setSaga(final Saga saga) {
        this.saga = saga;
    }
}