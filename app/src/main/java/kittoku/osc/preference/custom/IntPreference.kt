package kittoku.osc.preference.custom

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import kittoku.osc.R
import kittoku.osc.preference.OscPrefKey


internal abstract class IntPreference(context: Context, attrs: AttributeSet) : OscEditTextPreference(context, attrs), OscPreference {
    override val inputType = InputType.TYPE_CLASS_NUMBER
}

internal class SSLPortPreference(context: Context, attrs: AttributeSet) : IntPreference(context, attrs) {
    override val oscPrefKey = OscPrefKey.SSL_PORT
    override val parentKey: OscPrefKey? = null
    override val preferenceTitle = context.getString(R.string.int_port_number)
}

internal class ProxyPortPreference(context: Context, attrs: AttributeSet) : IntPreference(context, attrs) {
    override val oscPrefKey = OscPrefKey.PROXY_PORT
    override val parentKey = OscPrefKey.PROXY_DO_USE_PROXY
    override val preferenceTitle = context.getString(R.string.int_proxy_port_number)
}

internal class PPPMruPreference(context: Context, attrs: AttributeSet) : IntPreference(context, attrs) {
    override val oscPrefKey = OscPrefKey.PPP_MRU
    override val parentKey: OscPrefKey? = null
    override val preferenceTitle = context.getString(R.string.int_mru)
}

internal class PPPMtuPreference(context: Context, attrs: AttributeSet) : IntPreference(context, attrs) {
    override val oscPrefKey = OscPrefKey.PPP_MTU
    override val parentKey: OscPrefKey? = null
    override val preferenceTitle = context.getString(R.string.int_mtu)
}

internal class PPPAuthTimeoutPreference(context: Context, attrs: AttributeSet) : IntPreference(context, attrs) {
    override val oscPrefKey = OscPrefKey.PPP_AUTH_TIMEOUT
    override val parentKey: OscPrefKey? = null
    override val preferenceTitle = context.getString(R.string.int_timeout_seconds)
}

internal class ReconnectionCountPreference(context: Context, attrs: AttributeSet) : IntPreference(context, attrs) {
    override val oscPrefKey = OscPrefKey.RECONNECTION_COUNT
    override val parentKey = OscPrefKey.RECONNECTION_ENABLED
    override val preferenceTitle = context.getString(R.string.int_retr_attempts)
}

internal class ReconnectionIntervalPreference(context: Context, attrs: AttributeSet) : IntPreference(context, attrs) {
    override val oscPrefKey = OscPrefKey.RECONNECTION_INTERVAL
    override val parentKey = OscPrefKey.RECONNECTION_ENABLED
    override val preferenceTitle = context.getString(R.string.int_retr_interval_seconds)
}
