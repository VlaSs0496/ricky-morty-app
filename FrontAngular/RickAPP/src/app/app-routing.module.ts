import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'home',
    loadChildren: () => import('./home/home.module').then( m => m.HomePageModule)
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },

  {
    path: 'episodes',
    loadChildren: () => import('./episodes/episodes.module').then( m => m.EpisodesPageModule)
  },
  {
    path: 'character',
    loadChildren: () => import('./character/character.module').then( m => m.CharacterPageModule)
  },
  {
    path: 'profile-character/:id',
    loadChildren: () => import('./profile-character/profile-character.module').then( m => m.ProfileCharacterPageModule)
  },
  {
    path: 'single-episode/:id',
    loadChildren: () => import('./single-episode/single-episode.module').then( m => m.SingleEpisodePageModule)
  },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
