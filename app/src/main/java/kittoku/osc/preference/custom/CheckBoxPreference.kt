package kittoku.osc.preference.custom

import android.content.Context
import android.util.AttributeSet
import androidx.preference.CheckBoxPreference
import kittoku.osc.R
import kittoku.osc.preference.OscPrefKey
import kittoku.osc.preference.accessor.getBooleanPrefValue


internal abstract class ModifiedCheckBoxPreference(context: Context, attrs: AttributeSet) : CheckBoxPreference(context, attrs), OscPreference {
    override fun updateView() {
        isChecked = getBooleanPrefValue(oscPrefKey, sharedPreferences!!)
    }

    override fun onAttached() {
        initialize()
    }
}

internal class SSLDoVerifyPreference(context: Context, attrs: AttributeSet) : ModifiedCheckBoxPreference(context, attrs) {
    override val oscPrefKey = OscPrefKey.SSL_DO_VERIFY
    override val parentKey: OscPrefKey? = null
    override val preferenceTitle = context.getString(R.string.checkbox_verify_hostname)
}

internal class PPPIPv4EnabledPreference(context: Context, attrs: AttributeSet) : ModifiedCheckBoxPreference(context, attrs) {
    override val oscPrefKey = OscPrefKey.PPP_IPv4_ENABLED
    override val parentKey: OscPrefKey? = null
    override val preferenceTitle = context.getString(R.string.checkbox_enable_ipv4)
}

internal class PPPIPv6EnabledPreference(context: Context, attrs: AttributeSet) : ModifiedCheckBoxPreference(context, attrs) {
    override val oscPrefKey = OscPrefKey.PPP_IPv6_ENABLED
    override val parentKey: OscPrefKey? = null
    override val preferenceTitle = context.getString(R.string.checkbox_enable_ipv6)
}

internal class RouteDoAddDefaultRoutePreference(context: Context, attrs: AttributeSet) : ModifiedCheckBoxPreference(context, attrs) {
    override val oscPrefKey = OscPrefKey.ROUTE_DO_ADD_DEFAULT_ROUTE
    override val parentKey: OscPrefKey? = null
    override val preferenceTitle = context.getString(R.string.checkbox_add_default_routes)
}

internal class RouteDoRoutePrivateAddresses(context: Context, attrs: AttributeSet) : ModifiedCheckBoxPreference(context, attrs) {
    override val oscPrefKey = OscPrefKey.ROUTE_DO_ROUTE_PRIVATE_ADDRESSES
    override val parentKey: OscPrefKey? = null
    override val preferenceTitle = context.getString(R.string.checkbox_route_local_addresses)
}
