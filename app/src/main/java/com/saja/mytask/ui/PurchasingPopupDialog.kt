import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.saja.mytask.PopupAdapter
import com.saja.mytask.databinding.FragmentPopupBinding

class PurchasingPopupDialog : DialogFragment() {

    private var _binding: FragmentPopupBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPopupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.headerTextView.text = "Internet Purchasing Limits"

        val items = listOf("1 ", "2 ", "3 ", "4 ", "5 ", "6 ","7","8")

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = PopupAdapter(items)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
