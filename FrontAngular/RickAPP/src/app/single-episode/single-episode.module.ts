import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { SingleEpisodePageRoutingModule } from './single-episode-routing.module';

import { SingleEpisodePage } from './single-episode.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    SingleEpisodePageRoutingModule
  ],
  declarations: [SingleEpisodePage]
})
export class SingleEpisodePageModule {}
