package kittoku.osc.preference.custom

import android.content.Context
import android.util.AttributeSet
import androidx.preference.MultiSelectListPreference
import androidx.preference.Preference
import androidx.preference.Preference.SummaryProvider
import kittoku.osc.R
import kittoku.osc.preference.AUTH_PROTOCOL_EAP_MSCHAPv2
import kittoku.osc.preference.AUTH_PROTOCOL_MSCHAPv2
import kittoku.osc.preference.AUTH_PROTOCOl_PAP
import kittoku.osc.preference.OscPrefKey
import kittoku.osc.preference.accessor.getSetPrefValue
import javax.net.ssl.SSLContext


internal abstract class ModifiedMultiSelectListPreference(context: Context, attrs: AttributeSet) : MultiSelectListPreference(context, attrs), OscPreference {
    protected abstract val entryValues: Array<String>
    protected open val entries: Array<String>? = null
    protected open val provider: SummaryProvider<Preference>? = null

    override fun updateView() {
        values = getSetPrefValue(oscPrefKey, sharedPreferences!!)
    }

    override fun onAttached() {
        setEntryValues(entryValues)
        setEntries(entries ?: entryValues)

        summaryProvider = provider

        initialize()
    }
}

internal class SSLSuitesPreference(context: Context, attrs: AttributeSet) : ModifiedMultiSelectListPreference(context, attrs) {
    override val oscPrefKey = OscPrefKey.SSL_SUITES
    override val parentKey = OscPrefKey.SSL_DO_SELECT_SUITES
    override val preferenceTitle = context.getString(R.string.multiselect_cipher_suites)
    override val entryValues = SSLContext.getDefault().supportedSSLParameters.cipherSuites as Array<String>

    override val provider = SummaryProvider<Preference> {
        val currentValue = getSetPrefValue(oscPrefKey, it.sharedPreferences!!)
        context.getString(R.string.multiselect_suites_selected, currentValue.size)
    }
}

internal class PPPAuthProtocolsPreference(context: Context, attrs: AttributeSet) : ModifiedMultiSelectListPreference(context, attrs) {
    override val oscPrefKey = OscPrefKey.PPP_AUTH_PROTOCOLS
    override val parentKey = null
    override val preferenceTitle = context.getString(R.string.multiselect_auth_protocols)
    override val entryValues = arrayOf(
        AUTH_PROTOCOl_PAP,
        AUTH_PROTOCOL_MSCHAPv2,
        AUTH_PROTOCOL_EAP_MSCHAPv2,
    )

    override val provider = SummaryProvider<Preference> {
        val currentValue = getSetPrefValue(oscPrefKey, it.sharedPreferences!!)
        context.getString(R.string.multiselect_protocols_selected, currentValue.size)
    }
}
