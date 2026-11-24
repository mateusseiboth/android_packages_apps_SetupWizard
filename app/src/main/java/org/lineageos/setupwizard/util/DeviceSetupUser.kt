/*
 * SPDX-FileCopyrightText: The LineageOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

package org.lineageos.setupwizard.util

/** Which user runs the device setup (language, network, date) and which one only its own setup. */
object DeviceSetupUser {

    private const val SYSTEM_USER_ID = 0

    /**
     * The system user sets up the device. In headless system user mode the system user is no
     * person, so the user who runs the wizard before the device is provisioned (the first user,
     * created at first boot) sets it up instead.
     */
    fun isDeviceSetupUser(
        userId: Int,
        headlessSystemUserMode: Boolean,
        deviceProvisioned: Boolean,
    ): Boolean = userId == SYSTEM_USER_ID || (headlessSystemUserMode && !deviceProvisioned)
}
