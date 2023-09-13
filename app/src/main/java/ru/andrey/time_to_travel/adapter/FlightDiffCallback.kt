package ru.andrey.time_to_travel.adapter

import androidx.recyclerview.widget.DiffUtil
import ru.andrey.time_to_travel.dto.Flight

class FlightDiffCallback : DiffUtil.ItemCallback<Flight>() {

    override fun areItemsTheSame(oldItem: Flight, newItem: Flight): Boolean = oldItem.searchToken == newItem.searchToken

    override fun areContentsTheSame(oldItem: Flight, newItem: Flight): Boolean = oldItem == newItem
}