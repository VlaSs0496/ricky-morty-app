import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { SingleEpisodePage } from './single-episode.page';

const routes: Routes = [
  {
    path: '',
    component: SingleEpisodePage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class SingleEpisodePageRoutingModule {}
