package com.mobile.movieapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable
@Entity(tableName = "movies")
data class Movies (@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") @NotNull var id:Int,
                   @ColumnInfo(name = "name") @NotNull var name: String,
                   @ColumnInfo(name = "image") @NotNull var image:String,
                   @ColumnInfo(name = "price") @NotNull var price:Int) : Serializable{
}